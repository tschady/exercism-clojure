(ns minesweeper
  (:require [clojure.string :as str]))

(defn- str->board
  "Transform minesweeper board represented by string with newline separated rows into vector of vectors."
  [s]
  (mapv (comp vec seq) (str/split-lines s)))

(defn- board->str
  "Transform minesweeper board from vector of vectors into string."
  [board]
  (as-> board s
       (map str/join s)
       (str/join \newline s)
       (str/replace s #"0" " ")))

(defn- count-mine-neighbors
  "Return a count of mines surrounding the square given by x y coords."
  [[x y] board]
  (count (for [dx [-1 0 1]
               dy [-1 0 1]
               :let [cur-x (+ x dx)
                     cur-y (+ y dy)]
               :when (and (not (= 0 dx dy))
                          (= \* (get-in board [cur-y cur-x])))]
           true)))

(defn- place-mine-counts
  "Replace spaces in board with number representing how many mines are adjacent from the 8 possible squares."
  [board]
  (map-indexed (fn [y row]
                 (map-indexed (fn [x elem]
                                (if (= \space elem)
                                  (str (count-mine-neighbors [x y] board))
                                  elem))
                              row))
               board))

(defn draw
  "Given string input of board, replace all spaces with numbers representing adjacent mines.
  Keep 0 as a space char."
  [input-board-str]
  (-> input-board-str
      str->board
      place-mine-counts
      board->str))
