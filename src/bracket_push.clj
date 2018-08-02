(ns bracket-push)

(def ^:private closed->open-bracket {\] \[
                                     \} \{
                                     \) \(})

(def ^:private open-bracket (set (vals closed->open-bracket)))
(def ^:private closed-bracket (set (keys closed->open-bracket)))

(defn- stack-brackets
  "Push all brackets to stack, pop open bracket if given matching closed."
  [stack c]
  (cond
    (open-bracket c) (conj stack c)
    (closed-bracket c) (if (= (peek stack) (closed->open-bracket c))
                         (pop stack)
                         (conj stack c))
    :else stack))

(defn valid?
  "Determine if input string has valid bracket nesting structure."
  [s]
  (empty? (reduce stack-brackets [] (seq s))))
