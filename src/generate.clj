(ns generate
  (:require [page :refer [home about members result]]
            [hiccup.core :refer [html]]))

(defn -main []
  (spit "result.html" (html result))
  (spit "members.html" (html members))
  (spit "index.html" (html home))
  (spit "about.html" (html about)))
