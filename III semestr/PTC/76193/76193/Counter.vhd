library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;

entity Counter is
	port(LDN, CLR, DN, UP: in std_logic;
D: in std_logic_vector(3 downto 0);
		 CON, BON: out std_logic; 
       Qout: out std_logic_vector(3 downto 0));
end Counter;

architecture Behave of Counter is
  signal Q: std_logic_vector(3 downto 0) := "0000"; 
  signal internalClock, reset: std_logic;   
begin
  internalClock <= DN or UP;
  reset <= CLR and LDN;
  process(internalClock, reset) is
  begin
    if(reset = '0') then 
		if (CLR = '0') then
			Q <= "0000";
		elsif (LDN = '0') then
			Q <= D;
		end if;
		BON <= '0';
		CON <= '0';
	 elsif (rising_edge(internalClock)) then
		if (DN = '1') then
			if (Q = "0000") then BON <= '1';
			else BON <= '0';
			end if;
			Q <= Q - 1;
		elsif (UP = '1') then
			if (Q = "1111") then CON <= '1';
			else CON <= '0';
			end if;
			Q <= Q + 1;
		end if;
	 end if;
  end process;
  Qout <= Q;
end Behave;