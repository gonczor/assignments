vlog -work work /home/gonczor/altera/13.0sp1/quartus/projects/lab32/simulation/modelsim/Waveform1.vwf.vt
vsim -novopt -c -t 1ps -L cycloneii_ver -L altera_ver -L altera_mf_ver -L 220model_ver -L sgate work.lab32_vlg_vec_tst
onerror {resume}
add wave {lab32_vlg_vec_tst/i1/KEY}
add wave {lab32_vlg_vec_tst/i1/KEY[0]}
add wave {lab32_vlg_vec_tst/i1/LEDR}
add wave {lab32_vlg_vec_tst/i1/LEDR[7]}
add wave {lab32_vlg_vec_tst/i1/LEDR[6]}
add wave {lab32_vlg_vec_tst/i1/LEDR[5]}
add wave {lab32_vlg_vec_tst/i1/LEDR[4]}
add wave {lab32_vlg_vec_tst/i1/LEDR[3]}
add wave {lab32_vlg_vec_tst/i1/LEDR[2]}
add wave {lab32_vlg_vec_tst/i1/LEDR[1]}
add wave {lab32_vlg_vec_tst/i1/LEDR[0]}
run -all
