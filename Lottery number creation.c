/*
Lottery number creation program
Written by : Park jaehyeon
date : 2022-02-20
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void initialization(int* number) {
	int i = 0;

	for (i = 0; i < 6; i++) {
		number[i] = 0;
	}

}

void swap(int* a, int* b) {
	int temp = 0;
	temp = *a;
	*a = *b;
	*b = temp;
}

void show(int* number) {
	int i = 0;
	int sum = 0;
	
	printf("Lucky numbers is ");
	for (i = 0; i < 6; i++) {
		printf("%d ", number[i]);
		sum = sum + number[i];
	}
	printf("\n-------------------------\nThe sum of numbers is %d\n\n", sum);
	
}

void sort_num(int* number) {
	int i = 0;
	int j = 0;

	for (i = 0; i < 6; i++) {
		for (j = i + 1; j < 6; j++) {
			if (number[i] > number[j]) {
				swap(&number[i], &number[j]);
			}
		}
	}

}



void create_number(int* number) {
	int i = 0;
	int j = 0;
	int exception=40;
	int flag = 0;

	for (i = 0; i < 6; i++) {
		number[i] = rand() % 45 + 1;
		if (number[i] == exception) {
			i--;
			flag = 1;
			flag--;
		}
		// Remove duplicates
		if (i > 0 && flag == 0) {
			for (j = i - 1; j >= 0; j--) {
				if (number[i] == number[j]) {
					i = i - 1;
					j = -1;
				}
			}
		}
		
	}

	sort_num(number);

}

int compare(int* a, int* b) {
	int i = 0;
	int j = 0;

	for (i = 0; i < 6; i++) {
		for (j = 0; j < 6; j++) {
			if (a[i] == b[j]) {
				return 1;
			}
		}
	}
	return 0;
}

int sum_compare(int* number) {
	int i = 0;
	int sum = 0;

	for (i = 0; i < 6; i++) {
		sum = sum + number[i];
	}

	if (sum < 101 || sum > 160) {
		return 1;
	}

	return 0;
}


void main() {

	// Create variables
	// 'lotto_number' is a variable that contains a lottery number
	// 'i' is a variable for the repeat statement
	int last_number[5][6];
	int i=0;
	int j = 0;
	int flag = 0;

	//Initaialization

	for (i = 0; i < 5; i++) {
		initialization(last_number[i]);
	}

	srand((unsigned)time(NULL));

	

	for (i = 0; i < 5; i++) {
		create_number(last_number[i]);
		if (sum_compare(last_number[i]) == 1) {
			i--;
			flag = 1;
			flag--;
		}
		else if (i > 0 && flag == 0) {
			for (j = i - 1; j >= 0; j--) {
				flag = compare(last_number[i], last_number[j]);
				if (flag == 1) {
					i = i - 1;
					j = -1;
					flag--;
				}
			}
		}
	}


	for (i = 0; i < 5; i++) {
		show(last_number[i]);
	}


}