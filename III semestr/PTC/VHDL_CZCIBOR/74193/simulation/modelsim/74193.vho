-- Copyright (C) 1991-2013 Altera Corporation
-- Your use of Altera Corporation's design tools, logic functions 
-- and other software and tools, and its AMPP partner logic 
-- functions, and any output files from any of the foregoing 
-- (including device programming or simulation files), and any 
-- associated documentation or information are expressly subject 
-- to the terms and conditions of the Altera Program License 
-- Subscription Agreement, Altera MegaCore Function License 
-- Agreement, or other applicable license agreement, including, 
-- without limitation, that your use is for the sole purpose of 
-- programming logic devices manufactured by Altera and sold by 
-- Altera or its authorized distributors.  Please refer to the 
-- applicable agreement for further details.

-- VENDOR "Altera"
-- PROGRAM "Quartus II 32-bit"
-- VERSION "Version 13.0.1 Build 232 06/12/2013 Service Pack 1 SJ Web Edition"

-- DATE "01/18/2017 03:28:06"

-- 
-- Device: Altera EP2C35F672C6 Package FBGA672
-- 

-- 
-- This VHDL file should be used for ModelSim-Altera (VHDL) only
-- 

LIBRARY CYCLONEII;
LIBRARY IEEE;
USE CYCLONEII.CYCLONEII_COMPONENTS.ALL;
USE IEEE.STD_LOGIC_1164.ALL;

ENTITY 	\74193\ IS
    PORT (
	BON : OUT std_logic;
	CLR : IN std_logic;
	LDN : IN std_logic;
	B : IN std_logic;
	A : IN std_logic;
	DN : IN std_logic;
	UP : IN std_logic;
	C : IN std_logic;
	D : IN std_logic;
	CON : OUT std_logic;
	QD : OUT std_logic;
	QC : OUT std_logic;
	QB : OUT std_logic;
	QA : OUT std_logic
	);
END \74193\;

-- Design Ports Information
-- BON	=>  Location: PIN_J10,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
-- CON	=>  Location: PIN_C12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
-- QD	=>  Location: PIN_B12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
-- QC	=>  Location: PIN_G14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
-- QB	=>  Location: PIN_B14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
-- QA	=>  Location: PIN_J11,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
-- DN	=>  Location: PIN_C13,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- UP	=>  Location: PIN_D13,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- C	=>  Location: PIN_A14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- LDN	=>  Location: PIN_D14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- CLR	=>  Location: PIN_F12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- B	=>  Location: PIN_B11,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- A	=>  Location: PIN_C11,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
-- D	=>  Location: PIN_G12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default


ARCHITECTURE structure OF \74193\ IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL devoe : std_logic := '1';
SIGNAL devclrn : std_logic := '1';
SIGNAL devpor : std_logic := '1';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL ww_BON : std_logic;
SIGNAL ww_CLR : std_logic;
SIGNAL ww_LDN : std_logic;
SIGNAL ww_B : std_logic;
SIGNAL ww_A : std_logic;
SIGNAL ww_DN : std_logic;
SIGNAL ww_UP : std_logic;
SIGNAL ww_C : std_logic;
SIGNAL ww_D : std_logic;
SIGNAL ww_CON : std_logic;
SIGNAL ww_QD : std_logic;
SIGNAL ww_QC : std_logic;
SIGNAL ww_QB : std_logic;
SIGNAL ww_QA : std_logic;
SIGNAL \92~combout\ : std_logic;
SIGNAL \93~combout\ : std_logic;
SIGNAL \94~combout\ : std_logic;
SIGNAL \91~combout\ : std_logic;
SIGNAL \24~1_combout\ : std_logic;
SIGNAL \DN~combout\ : std_logic;
SIGNAL \UP~combout\ : std_logic;
SIGNAL \B~combout\ : std_logic;
SIGNAL \CLR~combout\ : std_logic;
SIGNAL \LDN~combout\ : std_logic;
SIGNAL \88~0_combout\ : std_logic;
SIGNAL \D~combout\ : std_logic;
SIGNAL \55~combout\ : std_logic;
SIGNAL \23~1_combout\ : std_logic;
SIGNAL \23~3_combout\ : std_logic;
SIGNAL \23~0_combout\ : std_logic;
SIGNAL \23~_emulated_regout\ : std_logic;
SIGNAL \23~2_combout\ : std_logic;
SIGNAL \C~combout\ : std_logic;
SIGNAL \87~0_combout\ : std_logic;
SIGNAL \54~combout\ : std_logic;
SIGNAL \24~3_combout\ : std_logic;
SIGNAL \24~0_combout\ : std_logic;
SIGNAL \24~_emulated_regout\ : std_logic;
SIGNAL \24~2_combout\ : std_logic;
SIGNAL \A~combout\ : std_logic;
SIGNAL \85~0_combout\ : std_logic;
SIGNAL \52~combout\ : std_logic;
SIGNAL \26~1_combout\ : std_logic;
SIGNAL \26~3_combout\ : std_logic;
SIGNAL \26~0_combout\ : std_logic;
SIGNAL \26~_emulated_regout\ : std_logic;
SIGNAL \26~2_combout\ : std_logic;
SIGNAL \53~combout\ : std_logic;
SIGNAL \25~1_combout\ : std_logic;
SIGNAL \25~3_combout\ : std_logic;
SIGNAL \86~0_combout\ : std_logic;
SIGNAL \25~0_combout\ : std_logic;
SIGNAL \25~_emulated_regout\ : std_logic;
SIGNAL \25~2_combout\ : std_logic;
SIGNAL \22~0_combout\ : std_logic;
SIGNAL \28~combout\ : std_logic;
SIGNAL \21~0_combout\ : std_logic;
SIGNAL \27~combout\ : std_logic;
SIGNAL \ALT_INV_93~combout\ : std_logic;
SIGNAL \ALT_INV_27~combout\ : std_logic;
SIGNAL \ALT_INV_28~combout\ : std_logic;

BEGIN

BON <= ww_BON;
ww_CLR <= CLR;
ww_LDN <= LDN;
ww_B <= B;
ww_A <= A;
ww_DN <= DN;
ww_UP <= UP;
ww_C <= C;
ww_D <= D;
CON <= ww_CON;
QD <= ww_QD;
QC <= ww_QC;
QB <= ww_QB;
QA <= ww_QA;
ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;
\ALT_INV_93~combout\ <= NOT \93~combout\;
\ALT_INV_27~combout\ <= NOT \27~combout\;
\ALT_INV_28~combout\ <= NOT \28~combout\;

-- Location: LCCOMB_X31_Y35_N16
\92\ : cycloneii_lcell_comb
-- Equation(s):
-- \92~combout\ = LCELL((\26~2_combout\ & ((\UP~combout\) # ((!\25~2_combout\)))) # (!\26~2_combout\ & (((\DN~combout\) # (\25~2_combout\)))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010111111111100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \UP~combout\,
	datab => \DN~combout\,
	datac => \26~2_combout\,
	datad => \25~2_combout\,
	combout => \92~combout\);

-- Location: LCCOMB_X31_Y35_N14
\93\ : cycloneii_lcell_comb
-- Equation(s):
-- \93~combout\ = LCELL((\26~2_combout\ & (!\UP~combout\)) # (!\26~2_combout\ & ((!\DN~combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0101000001011111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \UP~combout\,
	datac => \26~2_combout\,
	datad => \DN~combout\,
	combout => \93~combout\);

-- Location: LCCOMB_X31_Y35_N18
\94\ : cycloneii_lcell_comb
-- Equation(s):
-- \94~combout\ = LCELL((\UP~combout\ & \DN~combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \UP~combout\,
	datad => \DN~combout\,
	combout => \94~combout\);

-- Location: LCCOMB_X31_Y35_N30
\91\ : cycloneii_lcell_comb
-- Equation(s):
-- \91~combout\ = LCELL((!\21~0_combout\ & !\22~0_combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000000001111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \21~0_combout\,
	datad => \22~0_combout\,
	combout => \91~combout\);

-- Location: LCCOMB_X31_Y35_N12
\24~1\ : cycloneii_lcell_comb
-- Equation(s):
-- \24~1_combout\ = (!\87~0_combout\ & ((\54~combout\) # (\24~1_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011001100110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \87~0_combout\,
	datac => \54~combout\,
	datad => \24~1_combout\,
	combout => \24~1_combout\);

-- Location: PIN_C13,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\DN~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_DN,
	combout => \DN~combout\);

-- Location: PIN_D13,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\UP~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_UP,
	combout => \UP~combout\);

-- Location: PIN_B11,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\B~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_B,
	combout => \B~combout\);

-- Location: PIN_F12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\CLR~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_CLR,
	combout => \CLR~combout\);

-- Location: PIN_D14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\LDN~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_LDN,
	combout => \LDN~combout\);

-- Location: LCCOMB_X30_Y35_N22
\88~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \88~0_combout\ = (\CLR~combout\) # ((!\D~combout\ & !\LDN~combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100110111001101",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \D~combout\,
	datab => \CLR~combout\,
	datac => \LDN~combout\,
	combout => \88~0_combout\);

-- Location: PIN_G12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\D~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_D,
	combout => \D~combout\);

-- Location: LCCOMB_X30_Y35_N24
\55\ : cycloneii_lcell_comb
-- Equation(s):
-- \55~combout\ = (!\LDN~combout\ & \D~combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011000000110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \LDN~combout\,
	datac => \D~combout\,
	combout => \55~combout\);

-- Location: LCCOMB_X30_Y35_N26
\23~1\ : cycloneii_lcell_comb
-- Equation(s):
-- \23~1_combout\ = (!\88~0_combout\ & ((\55~combout\) # (\23~1_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011001100110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \88~0_combout\,
	datac => \55~combout\,
	datad => \23~1_combout\,
	combout => \23~1_combout\);

-- Location: LCCOMB_X30_Y35_N28
\23~3\ : cycloneii_lcell_comb
-- Equation(s):
-- \23~3_combout\ = \23~1_combout\ $ (!\23~2_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100110000110011",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \23~1_combout\,
	datad => \23~2_combout\,
	combout => \23~3_combout\);

-- Location: LCCOMB_X30_Y35_N18
\23~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \23~0_combout\ = (\55~combout\) # (\88~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \55~combout\,
	datad => \88~0_combout\,
	combout => \23~0_combout\);

-- Location: LCFF_X30_Y35_N29
\23~_emulated\ : cycloneii_lcell_ff
PORT MAP (
	clk => \91~combout\,
	datain => \23~3_combout\,
	aclr => \23~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \23~_emulated_regout\);

-- Location: LCCOMB_X30_Y35_N12
\23~2\ : cycloneii_lcell_comb
-- Equation(s):
-- \23~2_combout\ = (!\88~0_combout\ & ((\55~combout\) # (\23~1_combout\ $ (\23~_emulated_regout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011000100110010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \23~1_combout\,
	datab => \88~0_combout\,
	datac => \55~combout\,
	datad => \23~_emulated_regout\,
	combout => \23~2_combout\);

-- Location: PIN_A14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\C~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_C,
	combout => \C~combout\);

-- Location: LCCOMB_X31_Y35_N24
\87~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \87~0_combout\ = (\CLR~combout\) # ((!\LDN~combout\ & !\C~combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000011110101",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \LDN~combout\,
	datac => \CLR~combout\,
	datad => \C~combout\,
	combout => \87~0_combout\);

-- Location: LCCOMB_X31_Y35_N20
\54\ : cycloneii_lcell_comb
-- Equation(s):
-- \54~combout\ = (!\LDN~combout\ & \C~combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0101010100000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \LDN~combout\,
	datad => \C~combout\,
	combout => \54~combout\);

-- Location: LCCOMB_X31_Y35_N6
\24~3\ : cycloneii_lcell_comb
-- Equation(s):
-- \24~3_combout\ = \24~1_combout\ $ (!\24~2_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010101001010101",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \24~1_combout\,
	datad => \24~2_combout\,
	combout => \24~3_combout\);

-- Location: LCCOMB_X31_Y35_N8
\24~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \24~0_combout\ = (\54~combout\) # (\87~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \54~combout\,
	datad => \87~0_combout\,
	combout => \24~0_combout\);

-- Location: LCFF_X31_Y35_N7
\24~_emulated\ : cycloneii_lcell_ff
PORT MAP (
	clk => \92~combout\,
	datain => \24~3_combout\,
	aclr => \24~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \24~_emulated_regout\);

-- Location: LCCOMB_X31_Y35_N22
\24~2\ : cycloneii_lcell_comb
-- Equation(s):
-- \24~2_combout\ = (!\87~0_combout\ & ((\54~combout\) # (\24~1_combout\ $ (\24~_emulated_regout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011000100110010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \24~1_combout\,
	datab => \87~0_combout\,
	datac => \54~combout\,
	datad => \24~_emulated_regout\,
	combout => \24~2_combout\);

-- Location: PIN_C11,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\A~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "input",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => GND,
	padio => ww_A,
	combout => \A~combout\);

-- Location: LCCOMB_X30_Y35_N8
\85~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \85~0_combout\ = (\CLR~combout\) # ((!\LDN~combout\ & !\A~combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100110011001111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \CLR~combout\,
	datac => \LDN~combout\,
	datad => \A~combout\,
	combout => \85~0_combout\);

-- Location: LCCOMB_X30_Y35_N16
\52\ : cycloneii_lcell_comb
-- Equation(s):
-- \52~combout\ = (\A~combout\ & !\LDN~combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000110000001100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \A~combout\,
	datac => \LDN~combout\,
	combout => \52~combout\);

-- Location: LCCOMB_X30_Y35_N2
\26~1\ : cycloneii_lcell_comb
-- Equation(s):
-- \26~1_combout\ = (!\85~0_combout\ & ((\52~combout\) # (\26~1_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011001100110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \85~0_combout\,
	datac => \52~combout\,
	datad => \26~1_combout\,
	combout => \26~1_combout\);

-- Location: LCCOMB_X30_Y35_N10
\26~3\ : cycloneii_lcell_comb
-- Equation(s):
-- \26~3_combout\ = \26~1_combout\ $ (!\26~2_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100110000110011",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \26~1_combout\,
	datad => \26~2_combout\,
	combout => \26~3_combout\);

-- Location: LCCOMB_X30_Y35_N20
\26~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \26~0_combout\ = (\85~0_combout\) # (\52~combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111110011111100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \85~0_combout\,
	datac => \52~combout\,
	combout => \26~0_combout\);

-- Location: LCFF_X30_Y35_N11
\26~_emulated\ : cycloneii_lcell_ff
PORT MAP (
	clk => \94~combout\,
	datain => \26~3_combout\,
	aclr => \26~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \26~_emulated_regout\);

-- Location: LCCOMB_X30_Y35_N30
\26~2\ : cycloneii_lcell_comb
-- Equation(s):
-- \26~2_combout\ = (!\85~0_combout\ & ((\52~combout\) # (\26~1_combout\ $ (\26~_emulated_regout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000101100001110",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \52~combout\,
	datab => \26~1_combout\,
	datac => \85~0_combout\,
	datad => \26~_emulated_regout\,
	combout => \26~2_combout\);

-- Location: LCCOMB_X30_Y35_N4
\53\ : cycloneii_lcell_comb
-- Equation(s):
-- \53~combout\ = (\B~combout\ & !\LDN~combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000101000001010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \B~combout\,
	datac => \LDN~combout\,
	combout => \53~combout\);

-- Location: LCCOMB_X31_Y35_N2
\25~1\ : cycloneii_lcell_comb
-- Equation(s):
-- \25~1_combout\ = (!\86~0_combout\ & ((\53~combout\) # (\25~1_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0101010101010000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \86~0_combout\,
	datac => \53~combout\,
	datad => \25~1_combout\,
	combout => \25~1_combout\);

-- Location: LCCOMB_X31_Y35_N10
\25~3\ : cycloneii_lcell_comb
-- Equation(s):
-- \25~3_combout\ = \25~1_combout\ $ (!\25~2_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100110000110011",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \25~1_combout\,
	datad => \25~2_combout\,
	combout => \25~3_combout\);

-- Location: LCCOMB_X30_Y35_N14
\86~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \86~0_combout\ = (\CLR~combout\) # ((!\B~combout\ & !\LDN~combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000111110001",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \B~combout\,
	datab => \LDN~combout\,
	datac => \CLR~combout\,
	combout => \86~0_combout\);

-- Location: LCCOMB_X31_Y35_N26
\25~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \25~0_combout\ = (\53~combout\) # (\86~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \53~combout\,
	datad => \86~0_combout\,
	combout => \25~0_combout\);

-- Location: LCFF_X31_Y35_N11
\25~_emulated\ : cycloneii_lcell_ff
PORT MAP (
	clk => \ALT_INV_93~combout\,
	datain => \25~3_combout\,
	aclr => \25~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	regout => \25~_emulated_regout\);

-- Location: LCCOMB_X31_Y35_N0
\25~2\ : cycloneii_lcell_comb
-- Equation(s):
-- \25~2_combout\ = (!\86~0_combout\ & ((\53~combout\) # (\25~1_combout\ $ (\25~_emulated_regout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0101000101010100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \86~0_combout\,
	datab => \25~1_combout\,
	datac => \53~combout\,
	datad => \25~_emulated_regout\,
	combout => \25~2_combout\);

-- Location: LCCOMB_X31_Y35_N28
\22~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \22~0_combout\ = (!\DN~combout\ & (!\24~2_combout\ & (!\26~2_combout\ & !\25~2_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000000000001",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \DN~combout\,
	datab => \24~2_combout\,
	datac => \26~2_combout\,
	datad => \25~2_combout\,
	combout => \22~0_combout\);

-- Location: LCCOMB_X30_Y35_N6
\28\ : cycloneii_lcell_comb
-- Equation(s):
-- \28~combout\ = (!\23~2_combout\ & \22~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000111100000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \23~2_combout\,
	datad => \22~0_combout\,
	combout => \28~combout\);

-- Location: LCCOMB_X31_Y35_N4
\21~0\ : cycloneii_lcell_comb
-- Equation(s):
-- \21~0_combout\ = (!\UP~combout\ & (\25~2_combout\ & (\26~2_combout\ & \24~2_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0100000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \UP~combout\,
	datab => \25~2_combout\,
	datac => \26~2_combout\,
	datad => \24~2_combout\,
	combout => \21~0_combout\);

-- Location: LCCOMB_X30_Y35_N0
\27\ : cycloneii_lcell_comb
-- Equation(s):
-- \27~combout\ = (\23~2_combout\ & \21~0_combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \23~2_combout\,
	datad => \21~0_combout\,
	combout => \27~combout\);

-- Location: PIN_J10,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
\BON~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "output",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	datain => \ALT_INV_28~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => VCC,
	padio => ww_BON);

-- Location: PIN_C12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
\CON~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "output",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	datain => \ALT_INV_27~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => VCC,
	padio => ww_CON);

-- Location: PIN_B12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
\QD~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "output",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	datain => \23~2_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => VCC,
	padio => ww_QD);

-- Location: PIN_G14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
\QC~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "output",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	datain => \24~2_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => VCC,
	padio => ww_QC);

-- Location: PIN_B14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
\QB~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "output",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	datain => \25~2_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => VCC,
	padio => ww_QB);

-- Location: PIN_J11,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 24mA
\QA~I\ : cycloneii_io
-- pragma translate_off
GENERIC MAP (
	input_async_reset => "none",
	input_power_up => "low",
	input_register_mode => "none",
	input_sync_reset => "none",
	oe_async_reset => "none",
	oe_power_up => "low",
	oe_register_mode => "none",
	oe_sync_reset => "none",
	operation_mode => "output",
	output_async_reset => "none",
	output_power_up => "low",
	output_register_mode => "none",
	output_sync_reset => "none")
-- pragma translate_on
PORT MAP (
	datain => \26~2_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	devoe => ww_devoe,
	oe => VCC,
	padio => ww_QA);
END structure;


