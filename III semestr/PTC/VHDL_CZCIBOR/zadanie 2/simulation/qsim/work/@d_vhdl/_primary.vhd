library verilog;
use verilog.vl_types.all;
entity D_vhdl is
    port(
        KEY             : in     vl_logic_vector(0 downto 0);
        LEDR            : out    vl_logic_vector(3 downto 0)
    );
end D_vhdl;
