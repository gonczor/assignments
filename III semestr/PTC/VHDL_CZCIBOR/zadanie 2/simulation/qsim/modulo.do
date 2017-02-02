onerror {quit -f}
vlib work
vlog -work work modulo.vo
vlog -work work modulo.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.D_vhdl_vlg_vec_tst
vcd file -direction modulo.msim.vcd
vcd add -internal D_vhdl_vlg_vec_tst/*
vcd add -internal D_vhdl_vlg_vec_tst/i1/*
add wave /*
run -all
