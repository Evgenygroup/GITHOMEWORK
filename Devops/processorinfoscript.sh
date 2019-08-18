#!/bin/bash
 cat /proc/cpuinfo > processorinfo

echo >> processorinfo 
echo >> processorinfo
cat /proc/cpuinfo | grep 'vendor_id'  | head -1 >> processorinfo
echo >> processorinfo
cat /proc/cpuinfo | grep 'vendor_id' | head -1 | awk '{print $3}'>>processorinfo

