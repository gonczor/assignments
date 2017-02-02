library verilog;
use verilog.vl_types.all;
entity tester is
    port(
        KEY             : in     vl_logic_vector(1 downto 0);
        LEDR            : out    vl_logic_vector(5 downto 0)
    );
end tester;
