library verilog;
use verilog.vl_types.all;
entity Eight_Bit_Counter_vlg_sample_tst is
    port(
        Clk             : in     vl_logic;
        ClrN            : in     vl_logic;
        Din1            : in     vl_logic_vector(3 downto 0);
        Din2            : in     vl_logic_vector(3 downto 0);
        LdN             : in     vl_logic;
        P               : in     vl_logic;
        T1              : in     vl_logic;
        sampler_tx      : out    vl_logic
    );
end Eight_Bit_Counter_vlg_sample_tst;
