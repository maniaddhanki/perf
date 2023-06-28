#include <algorithm>
#include <iostream>
#include <ostream>
#include <vector>

std::vector<int> fill_array(std::vector<int> nums) {
  int range = 100;
  for (int i = 0; i < nums.size(); i++) {
    nums[i] = ((std::rand() % RAND_MAX) % range);
  }
  return nums;
}

int median(std::vector<int> nums) {
  std::sort(nums.begin(), nums.end());
  int mid_index = (nums.size() / 2) + 1;
  return nums[mid_index];
}

int main() {
  int count = 50000000; // 5,00,00,000
  std::vector<int> nums(count);
  nums = fill_array(nums);
  std::cout << median(nums) << std::endl;
}