library verilog;
use verilog.vl_types.all;
entity transkoder_vlg_check_tst is
    port(
        ledr            : in     vl_logic_vector(2 downto 0);
        sampler_rx      : in     vl_logic
    );
end transkoder_vlg_check_tst;
