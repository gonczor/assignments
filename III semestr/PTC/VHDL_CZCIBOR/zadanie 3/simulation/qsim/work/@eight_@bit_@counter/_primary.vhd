library verilog;
use verilog.vl_types.all;
entity Eight_Bit_Counter is
    port(
        ClrN            : in     vl_logic;
        LdN             : in     vl_logic;
        P               : in     vl_logic;
        T1              : in     vl_logic;
        Clk             : in     vl_logic;
        Din1            : in     vl_logic_vector(3 downto 0);
        Din2            : in     vl_logic_vector(3 downto 0);
        Qout            : out    vl_logic_vector(7 downto 0);
        Carry2          : out    vl_logic
    );
end Eight_Bit_Counter;
