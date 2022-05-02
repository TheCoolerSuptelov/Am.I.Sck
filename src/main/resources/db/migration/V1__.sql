CREATE TABLE actor (
  id UUID NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255),
   password VARCHAR(255),
   CONSTRAINT pk_actor PRIMARY KEY (id)
);

CREATE TABLE authorities (
  id UUID NOT NULL,
   title VARCHAR(255),
   CONSTRAINT pk_authorities PRIMARY KEY (id)
);

CREATE TABLE authorities_actors (
  actors_id UUID NOT NULL,
   authorities_id UUID NOT NULL,
   CONSTRAINT pk_authorities_actors PRIMARY KEY (actors_id, authorities_id)
);

CREATE TABLE clients (
  id UUID NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255),
   address VARCHAR(255),
   date_of_birth date,
   actor_id UUID,
   CONSTRAINT pk_clients PRIMARY KEY (id)
);

CREATE TABLE nurse (
  id UUID NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255),
   date_of_birth INTEGER,
   actor_id UUID,
   CONSTRAINT pk_nurse PRIMARY KEY (id)
);

CREATE TABLE service_order (
  id UUID NOT NULL,
   date date,
   number VARCHAR(255),
   clients_id UUID,
   nurse_id UUID,
   CONSTRAINT pk_service_order PRIMARY KEY (id)
);

CREATE TABLE services_log (
  id UUID NOT NULL,
   clients_id UUID,
   nurse_id UUID,
   service_order_id UUID,
   CONSTRAINT pk_services_log PRIMARY KEY (id)
);

ALTER TABLE clients ADD CONSTRAINT uc_clients_actor UNIQUE (actor_id);

ALTER TABLE nurse ADD CONSTRAINT uc_nurse_actor UNIQUE (actor_id);

ALTER TABLE clients ADD CONSTRAINT FK_CLIENTS_ON_ACTOR FOREIGN KEY (actor_id) REFERENCES actor (id);

ALTER TABLE nurse ADD CONSTRAINT FK_NURSE_ON_ACTOR FOREIGN KEY (actor_id) REFERENCES actor (id);

ALTER TABLE services_log ADD CONSTRAINT FK_SERVICES_LOG_ON_CLIENTS FOREIGN KEY (clients_id) REFERENCES clients (id);

ALTER TABLE services_log ADD CONSTRAINT FK_SERVICES_LOG_ON_NURSE FOREIGN KEY (nurse_id) REFERENCES nurse (id);

ALTER TABLE services_log ADD CONSTRAINT FK_SERVICES_LOG_ON_SERVICE_ORDER FOREIGN KEY (service_order_id) REFERENCES service_order (id);

ALTER TABLE service_order ADD CONSTRAINT FK_SERVICE_ORDER_ON_CLIENTS FOREIGN KEY (clients_id) REFERENCES clients (id);

ALTER TABLE service_order ADD CONSTRAINT FK_SERVICE_ORDER_ON_NURSE FOREIGN KEY (nurse_id) REFERENCES nurse (id);

ALTER TABLE authorities_actors ADD CONSTRAINT fk_autact_on_actor FOREIGN KEY (actors_id) REFERENCES actor (id);

ALTER TABLE authorities_actors ADD CONSTRAINT fk_autact_on_authorities FOREIGN KEY (authorities_id) REFERENCES authorities (id);