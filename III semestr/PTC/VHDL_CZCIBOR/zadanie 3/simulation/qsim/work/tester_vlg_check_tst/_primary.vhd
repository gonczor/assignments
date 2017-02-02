library verilog;
use verilog.vl_types.all;
entity tester_vlg_check_tst is
    port(
        LEDR            : in     vl_logic_vector(5 downto 0);
        sampler_rx      : in     vl_logic
    );
end tester_vlg_check_tst;
