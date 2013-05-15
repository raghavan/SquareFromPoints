mkdir shortened
var=$( ls flip* )
echo $var
k=1
for j in $var
do
split -b 8000 $j splitted
    for i in $( ls splitted* )
    do
    mv -f $i shortened/trip_$k.txt
    ((k++))
    done
rm $j
done
