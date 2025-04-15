# nc7, lc36, https://leetcode.com/problems/valid-sudoku/description/

# time complexity: O(N^2), N = 9, => O(1)
# space complextity: O(3N), N=9, => O(1)

def is_valid_sudoku(board)
  row_sets, col_sets, box_sets = [], [], []

  9.times do
    row_sets << Set.new
    col_sets << Set.new
    box_sets << Set.new
  end

  for i in 0...9
    for j in 0...9
      val = board[i][j]

      next if val == "."

      box_id = (i/3) * 3 + j/3

      return false if (row_sets[i].include?(val) || col_sets[j].include?(val) || box_sets[box_id].include?(val))

      row_sets[i].add(val)
      col_sets[j].add(val)
      box_sets[box_id].add(val)
    end
  end

  true
end