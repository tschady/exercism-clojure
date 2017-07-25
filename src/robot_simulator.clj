(ns robot-simulator)

(defn robot [loc direction] {:coordinates loc :bearing direction})

(def turn-map {:north {:l :west,  :r :east}
               :south {:l :east,  :r :west}
               :east  {:l :north, :r :south}
               :west  {:l :south, :r :north}})

(def move-map {:north [:y inc]
               :south [:y dec]
               :east  [:x inc]
               :west  [:x dec]})

(defn turn-right [bearing] (get-in turn-map [bearing :r]))
(defn turn-left  [bearing] (get-in turn-map [bearing :l]))

(defn advance [robot]
  (let [[axis delta] (move-map (robot :bearing))]
      (update-in robot [:coordinates axis] delta)))

(def command->action {\L #(update % :bearing turn-left)
                      \R #(update % :bearing turn-right)
                      \A #(advance %)})

(defn simulate [commands robot]
  (reduce #((command->action %2) %1) robot commands))
