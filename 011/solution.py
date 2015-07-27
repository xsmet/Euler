with open('matrix.txt') as file:
	lines = [line.strip('\n') for line in file]

for i in xrange(0, len(lines)):
	lines[i] = map(int, list(lines[i]))

print lines
