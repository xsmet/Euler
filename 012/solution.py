def main():
	num = find_first_triangular_number_with_n_divisors(500)
	print num

def find_first_triangular_number_with_n_divisors(n):
	num_divisors=0
	triangle_number=0
	triangle_number_index=0
	maxnum=0
	while num_divisors < n:
		triangle_number = find_next_triangle_number(triangle_number_index, triangle_number)
		triangle_number_index+=1
		num_divisors = find_number_of_divisors_for_n(triangle_number)
		if (num_divisors > maxnum):
			maxnum=num_divisors
		print "(%d) %d: %d\t(%d)" % (triangle_number_index, triangle_number, num_divisors, maxnum)
	return triangle_number

def find_number_of_divisors_for_n(n):
	num=1
	for i in range(1, n/2+1):
		if n%i == 0:
			num += 1
	return num

def find_next_triangle_number(triangle_number_index, triangle_number):
	return triangle_number+triangle_number_index+1

main()
