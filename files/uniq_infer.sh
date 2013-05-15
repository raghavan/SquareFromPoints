rm -r inferred
mkdir inferred
var=$( ls shortened/trip* )
echo $var
k=1
for j in $var
do
cat  $j | uniq >  inferred/tripinfer_$k.txt
((k++))
done
