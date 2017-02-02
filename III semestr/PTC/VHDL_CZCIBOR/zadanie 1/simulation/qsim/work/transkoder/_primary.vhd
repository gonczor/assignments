library verilog;
use verilog.vl_types.all;
entity transkoder is
    port(
        sw              : in     vl_logic_vector(2 downto 0);
        ledr            : out    vl_logic_vector(2 downto 0)
    );
end transkoder;
