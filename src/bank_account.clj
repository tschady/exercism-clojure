(ns bank-account)

(defn open-account
  "Return reference to new account with initial balance 0."
  []
  (atom 0))

(defn close-account
  "Sets account reference to nil, effectively preventing further updates."
  [account]
  (reset! account nil))

(defn get-balance
  "Return current account value."
  [account]
  @account)

(defn update-balance
  "Alter account balance by `amount`.  A negative `amount` will lower the
  available balance."
  [account amount]
  (swap! account + amount))
