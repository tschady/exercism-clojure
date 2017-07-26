(ns queen-attack)

(defn- same-rank? [[x1 y1] [x2 y2]] (= x1 x2))

(defn- same-file? [[x1 y1] [x2 y2]] (= y1 y2))

(defn- same-diag? [[x1 y1] [x2 y2]] (= (Math/abs (- x1 x2)) (Math/abs (- y1 y2))))

(defn can-attack
  "Predicate function returning true if given Queens are
  able to attack each other."
  [{:keys [w b]}]
  (or (same-rank? w b)
      (same-file? w b)
      (same-diag? w b)))

(defn- flat-index
  "Turn x,y coords into vector index of flat board position"
  [[x y]] (+ y (* 8 x)))

(defn- place-piece [coords char board]
  (if coords  ; FIXME:  nil-check
    (assoc board (flat-index coords) char)
    board))

(defn board-string
  "Represent pieces on chessboard in ASCII printout.
  Empty squares are '_'.  Currently supports 'W' and 'B'
  pieces, representing white and black queens."
  [{:keys [w b]}]
  (let [init-board (vec (repeat 64 "_"))]
    (as-> init-board board
      (place-piece w \W board)
      (place-piece b \B board)
      (partition 8 board)
      (map #(clojure.string/join " " %) board)
      (clojure.string/join "\n" board)
      (str board "\n"))))
