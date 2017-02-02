library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity transkoder is 
	port (
		sw: in std_logic_vector(2 downto 0);
		ledr: out std_logic_vector(2 downto 0)
	);
end transkoder;

architecture trans_arch of transkoder is

	begin process (sw)

		BEGIN
			case sw is
				when "000"=> ledr <= "000";
				when "001"=> ledr <= "011";
				when "010"=> ledr <= "100";
				when "011"=> ledr <= "010";
				when "100"=> ledr <= "010";
				when "101"=> ledr <= "101";
				when "110"=> ledr <= "110";
				when others=> ledr <= "000";
			end case;
			
	end process;

end trans_arch;