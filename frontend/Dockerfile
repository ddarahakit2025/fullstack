FROM    nginx:latest
EXPOSE  80
ADD     ./dist /usr/share/nginx/html
ADD     ./nginx/conf/default.conf /etc/nginx/conf.d/default.conf
CMD     ["nginx", "-g", "daemon off;"]