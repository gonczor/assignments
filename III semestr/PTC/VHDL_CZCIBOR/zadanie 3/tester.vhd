library IEEE;
use IEEE.std_logic_1164.all;

entity Eight_Bit_Counter is
  port(ClrN, LdN, P, T1, Clk: in std_logic;
       Din1, Din2: in std_logic_vector(3 downto 0);
       Qout: out std_logic_vector(7 downto 0);
       Carry2: out std_logic);
end Eight_Bit_Counter;

architecture Structure of Eight_Bit_Counter is
  component Counter74163 is
    port(LdN, ClrN, P, T, Clk: in std_logic;
         D: in std_logic_vector(3 downto 0);
         Cout: out std_logic; 
		   Qout: out std_logic_vector(3 downto 0));
  end component;

  signal Carry1:  std_logic;
  signal Qout1, Qout2:  std_logic_vector(3 downto 0);
begin

  ct1: Counter74163 port map(LdN,ClrN,P,T1,Clk,Din1,Carry1,Qout1);
  
  ct2: Counter74163 port map(LdN,ClrN,P,Carry1,Clk,Din2, Carry2, Qout2);
  
  Qout <= Qout2 & Qout1;

end Structure;



library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;

ENTITY tester IS
PORT(
SW : IN std_logic_vector(2 DOWNTO 0);
LEDR :OUT std_logic_vector(5 DOWNTO 0)
);
end tester;

ARCHITECTURE second OF tester IS
COMPONENT Counter74163 IS
PORT(LdN, ClrN, P, T, Clk: in std_logic;
       D: in std_logic_vector(3 downto 0);
       Cout: out std_logic; 
       Qout: out std_logic_vector(3 downto 0));
END COMPONENT Counter74163;
signal Cout1,qout32,qout16,qout8,qout4,qout2,qout1 : std_logic;
--signal reset : std_logic;
begin
ct1: Counter74163 PORT MAP(
Clk => SW(0),
ClrN => not(SW(2) or (qout8 and qout32)), 
Qout(3)=>qout8,
Qout(2) => qout4,
Qout(1) => qout2,
Qout(0) => qout1,
Cout => Cout1,
Ldn => SW(1),
P => SW(1),
T => SW(1),
D(0) => SW(2),
D(1) => SW(2),
D(2) => SW(2),
D(3) => SW(2)
);

ct2: Counter74163 PORT MAP(
Clk => SW(0),
ClrN => not(SW(2) or (qout8 and qout32)), 
Qout(1) => qout32,
Qout(0) => qout16,
Ldn => SW(1),
T => Cout1,
P => Cout1,
D(0) => SW(2),
D(1) => SW(2),
D(2) => SW(2),
D(3) => SW(2)
);

--COUT: process(qout32,qout16,qout8,qout4,qout2,qout1);
--begin
LEDR <= (qout32,qout16,qout8,qout4,qout2,qout1);
--end process COUT;
end second;