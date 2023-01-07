FROM mongo:latest
COPY --chown=999 --chmod=603 keyFile /etc/mongo/keyFile
RUN chmod 400 /etc/mongo/keyFile
COPY --chown=999 --chmod=603 mongod.conf /etc/mongod.conf