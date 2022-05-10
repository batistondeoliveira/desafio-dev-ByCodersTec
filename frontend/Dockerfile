FROM node:17-alpine

RUN apk add --no-cache bash

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

copy package.json /usr/src/app/package.json
RUN npm install --silent

CMD ["npm", "start"]