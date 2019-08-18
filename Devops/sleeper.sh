#!/bin/bash
for i in {1..100}
do
	 date +"%H:%M:%S"
	 ps -ef | wc -l
#	 sleep 5 
 done
