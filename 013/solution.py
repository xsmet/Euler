n=10

with open('matrix.txt') as file:
	lines = [line.strip('\n') for line in file]

for i in xrange(0, len(lines)):
	lines[i] = map(int, lines[i].split(' '))

w = len(lines[1])
h = len(lines)

sumstr='0'
for i in range(w):
	# Future optimization: stop when you know the first n digits won't change anymore
	sum=0
	for j in range(h):
		sum += lines[j][i]	
	buffer = 10*int(sumstr)
	sumstr = str(buffer+sum)
print sumstr
print sumstr[:10]
