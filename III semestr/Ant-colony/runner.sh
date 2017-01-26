#!/bin/bash

current_dir=$(pwd)

cd "out/production/Ant-colony"

for i in {1..3}
do
    # touch read${i}.txt write${i}.txt
    java ACS read${i}.txt write${i}.txt > ../../../adjustment_results/result${i}.txt #  create
done

cd "${current_dir}"
