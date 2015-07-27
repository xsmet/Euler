n = 4

with open('matrix.txt') as file:
	lines = [line.strip('\n') for line in file]

for i in xrange(0, len(lines)):
	lines[i] = map(int, lines[i].split(' '))

w = len(lines[1])
h = len(lines)

maxprod=0
for i in range(w-n+1): #i = 0..16
	for j in range(h-n+1): #j = 0..16
		prodhorz=1
		proddia=1
		prodvert=1
		proddia2=1
		for k in range(n): #k = 0..3
			prodhorz *= lines[i][j+k]
			proddia  *= lines[i+k][j+k]
			prodvert *= lines[i+k][j]
			proddia2 *= lines[i+k][j+n-1-k]

		thismax = max([prodhorz, prodvert, proddia, proddia2])

		if thismax > maxprod:
			print "%d, %d (%d): %d" % (i, j, lines[i][j], thismax)
			maxprod=thismax

print maxprod
