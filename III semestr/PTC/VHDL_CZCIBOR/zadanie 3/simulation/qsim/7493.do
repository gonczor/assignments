onerror {quit -f}
vlib work
vlog -work work 7493.vo
vlog -work work 7493.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.Eight_Bit_Counter_vlg_vec_tst
vcd file -direction 7493.msim.vcd
vcd add -internal Eight_Bit_Counter_vlg_vec_tst/*
vcd add -internal Eight_Bit_Counter_vlg_vec_tst/i1/*
add wave /*
run -all
