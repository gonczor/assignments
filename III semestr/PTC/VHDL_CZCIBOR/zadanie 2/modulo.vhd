LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY D IS
PORT(
D, CLK, RST :IN std_logic;
Q :OUT std_logic
);
end D;

ARCHITECTURE first OF D IS
begin
	synch_D: process(CLK, RST) begin
		if RST = '0' then
			Q <= '0';
		elsif rising_edge(CLK) then
			Q <= D;				
		end if;
	end process synch_D;
end first;

LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY D_vhdl IS
PORT(
KEY : IN std_logic_vector(0 DOWNTO 0);
LEDR :OUT std_logic_vector(3 DOWNTO 0)
);
end D_vhdl;

ARCHITECTURE second OF D_vhdl IS
COMPONENT D IS
PORT(
D, CLK, RST :IN std_logic;
Q :OUT std_logic
);
END COMPONENT D;
signal q1out,q2out,q3out,q4out : std_logic;
--signal reset : std_logic;
begin
DFF1: D PORT MAP(
D => not q1out,
CLK => KEY(0),
RST => not ((not q1out) and q2out and (not q3out) and q4out), 
Q => q1out
);
DFF2: D PORT MAP(
D => not q2out,
CLK => not q1out,
RST => not ((not q1out) and q2out and (not q3out) and q4out), 
Q => q2out
);
DFF3: D PORT MAP(
D => not q3out,
CLK => not q2out,
RST => not ((not q1out) and q2out and (not q3out) and q4out), 
Q => q3out
);
DFF4: D PORT MAP(
D => not q4out,
CLK => not q3out,
RST => not ((not q1out) and q2out and (not q3out) and q4out), 
Q => q4out
);



--COUT: process(q4out,q3out,q2out,q1out);
--begin
LEDR <= (q4out,q3out,q2out,q1out);
--end process COUT;
end second;