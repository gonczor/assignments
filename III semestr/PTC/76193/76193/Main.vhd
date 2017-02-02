library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;

ENTITY Main IS
	PORT(
		SW: IN std_logic_vector(1 DOWNTO 0);
		LEDR: OUT std_logic_vector(5 DOWNTO 0)
);
end Main;

ARCHITECTURE Behaviour OF Main IS
	COMPONENT Counter IS
	port(LDN, CLR, DN, UP: in std_logic;
			 D: in std_logic_vector(3 downto 0);
			 CON, BON: out std_logic; 
			 Qout: out std_logic_vector(3 downto 0));
	END COMPONENT Counter;
	
-- Q0 - Q5 idzie na LED, Q6 - tylko do badania przepełnienia licznika
signal counterUp, counterDown, Q0, Q1, Q2, Q3, Q4, Q5, Q6 : std_logic;
begin

		counter1: Counter PORT MAP(
			-- SW[1] do taktowania SW[0] o wyboru kierunku
			DN => (SW(1) AND (NOT SW(0))),
			UP => (SW(1) AND SW(0)),
			-- przepisanie wyjścia licznika na Q0-Q5
			Qout(3) => Q3,
			Qout(2) => Q2,
			Qout(1) => Q1,
			Qout(0) => Q0,
			CON => counterUp,
			BON => counterDown,
			-- zerowanie i ładowanie
			LDN => NOT (Q6 AND (SW(1) AND (NOT SW(0)))),
			CLR => NOT (Q5 AND (NOT Q4) AND Q3 AND Q2 AND Q1 AND Q0 AND (SW(1) AND SW(0))),
			D(0) => '1',
			D(1) => '1',
			D(2) => '1',
			D(3) => '1'
		);

		counter2: Counter PORT MAP(
			DN => counterDown,
			UP => counterUp,
			Qout(1) => Q5,
			Qout(0) => Q4,
			Qout(2) => Q6,
			LDN => NOT (Q6 AND (SW(1) AND (NOT SW(0)))),
			CLR => NOT (Q5 AND (NOT Q4) AND Q3 AND Q2 AND Q1 AND Q0 AND (SW(1) AND SW(0))),
			D(0) => '0',
			D(1) => '1',
			D(2) => '0',
			D(3) => '0'
		);

		LEDR <= (Q5, Q4, Q3, Q2, Q1, Q0);
end Behaviour;