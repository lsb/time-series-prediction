(ns time-series-prediction.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [time-series-prediction.predictor :as p]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/api/v1/demand-prediction" request (do (spit "/dev/stderr" request) "hello"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))

(defn async
  []
  (future
    (loop []
      (spit "/tmp/currenttimemillis" (System/currentTimeMillis))
      (Thread/sleep 1000)
      (recur))))
  