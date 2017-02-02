vlog -work work C:/Users/czcib/Desktop/new/zadanie 2/simulation/modelsim/Waveform.vwf.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.D_vhdl_vlg_vec_tst
onerror {resume}
add wave {D_vhdl_vlg_vec_tst/i1/KEY}
add wave {D_vhdl_vlg_vec_tst/i1/LEDR}
add wave {D_vhdl_vlg_vec_tst/i1/LEDR[3]}
add wave {D_vhdl_vlg_vec_tst/i1/LEDR[2]}
add wave {D_vhdl_vlg_vec_tst/i1/LEDR[1]}
add wave {D_vhdl_vlg_vec_tst/i1/LEDR[0]}
run -all
