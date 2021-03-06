-- 74163 FULLY SYNCHRONOUS COUNTER

library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;

entity Counter74163 is
  port(LdN, ClrN, P, T, Clk: in std_logic;
       D: in std_logic_vector(3 downto 0);
       Cout: out std_logic; 
       Qout: out std_logic_vector(3 downto 0));
end Counter74163;
architecture Behave of Counter74163 is
  signal Q: std_logic_vector(3 downto 0) := "0000";   
begin
  process(Clk)
  begin
    if rising_edge(Clk) then
      if ClrN = '0' then Q <= "0000";
      elsif LdN = '0' then Q <= D; 
      elsif (P and T) = '1' then Q <= Q + 1;
      end if;
    end if;
  end process;
  Qout <= Q;
  Cout <= '1' when Q = "1111" and T = '1' else '0';
end Behave;


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

