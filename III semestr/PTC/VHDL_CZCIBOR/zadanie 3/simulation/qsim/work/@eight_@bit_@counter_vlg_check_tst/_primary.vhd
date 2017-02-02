library verilog;
use verilog.vl_types.all;
entity Eight_Bit_Counter_vlg_check_tst is
    port(
        Carry2          : in     vl_logic;
        Qout            : in     vl_logic_vector(7 downto 0);
        sampler_rx      : in     vl_logic
    );
end Eight_Bit_Counter_vlg_check_tst;
