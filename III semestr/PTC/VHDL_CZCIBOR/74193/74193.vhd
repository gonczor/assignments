library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;

entity Counter74193 is
  port(KEY : IN std_logic_vector(0 DOWNTO 0);
		 SW : IN std_logic_vector(0 DOWNTO 0);
		 LEDR :OUT std_logic_vector(7 DOWNTO 0));
end Counter74193;

architecture arch of Counter74193 is
  signal Q: std_logic_vector(7 downto 0) := "00000000";   
begin
  process(KEY, SW)
  begin
    if rising_edge(SW(0)) then
		if KEY(0) = '0' then
			if Q = "00101111" then
				Q <= "00000000";
			else
				Q <= Q + 1;
			end if;
		else
			if Q = "00000000" then
				Q <= "00101111";
			else
				Q <= Q - 1;
			end if;
		end if;
    end if;
  end process;
  LEDR <= Q;
end arch;

