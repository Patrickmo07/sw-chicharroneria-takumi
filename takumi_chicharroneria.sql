create database if not exists takumi_chicharroneria;

use takumi_chicharroneria;

/* TABLAS */

/* GESTION DE CLIENTES */
CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(100) NOT NULL,
    telefono_cliente VARCHAR(20),
    correo_cliente VARCHAR(100),
    puntos_fidelidad INT DEFAULT 0
);

CREATE TABLE Promociones (
    id_promocion INT AUTO_INCREMENT PRIMARY KEY,
    descripcion_promocion TEXT NOT NULL,
    puntos_necesarios INT NOT NULL,
    descuento DECIMAL(5, 2) NOT NULL
);

/* GESTION DE INVENTARIO */

CREATE TABLE Proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_proveedor VARCHAR(100) NOT NULL,
    contacto_proveedor VARCHAR(100),
    telefono_proveedor VARCHAR(20),
    direccion_proveedor VARCHAR(200)
);

CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) NOT NULL
);

CREATE TABLE Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria)
);

CREATE TABLE Inventario (
	id_inventario INT AUTO_INCREMENT PRIMARY KEY,
    id_producto INT,
    id_proveedor INT,
    cantidad INT NOT NULL,
    tipo_movimiento VARCHAR(50) NOT NULL,
    fecha_movimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor)
);

/* GESTION DE PEDIDOS */


CREATE TABLE Pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    fecha_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado_pedido VARCHAR(100) DEFAULT 'Pendiente',
    tipo_entrega BOOL NULL;
    total DECIMAL(10, 2),
    id_detalle INT;
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
	FOREIGN KEY (id_detalle) REFERENCES  Detalle_Pedido(id_detalle)
);


CREATE TABLE Detalle_Pedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_producto INT,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2),
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES Inventario(id_producto)
);

/* INSERCCION DE DATOS */

INSERT INTO Clientes (nombre_cliente, telefono_cliente, correo_cliente, puntos_fidelidad)
VALUES
('Juan Pérez', '555-1234', 'juan.perez@example.com', 10),
('María López', '555-5678', 'maria.lopez@example.com', 25),
('Carlos Sánchez', '555-9876', 'carlos.sanchez@example.com', 5),
('Ana Gómez', '555-5432', 'ana.gomez@example.com', 15);

INSERT INTO Promociones (descripcion_promocion, puntos_necesarios, descuento)
VALUES
('10% de descuento en pedidos superiores a $20', 20, 10.00),
('Bebida gratis con 50 puntos de fidelidad', 50, 1.50),
('20% de descuento en productos de yuca', 30, 20.00);

INSERT INTO Proveedor (nombre_proveedor, contacto_proveedor, telefono_proveedor, direccion_proveedor)
VALUES
('Proveedor Central de Granos', 'Juan Martínez', '555-1001', 'Calle 10 #123, Ciudad A'),
('Distribuidora Frijoles del Valle', 'María González', '555-1002', 'Calle 20 #456, Ciudad B'),
('Alimentos Maizales S.A.', 'Carlos Rodríguez', '555-1003', 'Avenida 5 #789, Ciudad C'),
('Aceites y Granos S.A.', 'Lucía Pérez', '555-1004', 'Carretera Nacional km 15, Ciudad D'),
('Azucarera del Sur', 'Pedro Sánchez', '555-1005', 'Zona Industrial 3, Ciudad E'),
('Sales y Minerales del Norte', 'Ana Torres', '555-1006', 'Polígono 8, Ciudad F'),
('Pastas y Más S.A.', 'José Fernández', '555-1007', 'Boulevard Norte #333, Ciudad G'),
('Distribuidora Nutrición Natural', 'Sofía Ramírez', '555-1008', 'Colonia Centro #111, Ciudad H'),
('Cafetería del Campo', 'Miguel Ríos', '555-1009', 'Vía Rural #22, Ciudad I'),
('Legumbres Orgánicas S.A.', 'Paola Herrera', '555-1010', 'Calle Comercial #90, Ciudad J');

INSERT INTO Categoria (nombre_categoria)
VALUES
('Cereales'),
('Legumbres'),
('Aceites'),
('Edulcorantes'),
('Condimentos'),
('Bebidas');

INSERT INTO Producto (nombre_producto, descripcion, id_categoria)
VALUES
('Arroz a granel', 'Arroz blanco en sacos de 50kg', 1),
('Frijoles secos', 'Frijoles rojos empaquetados por 25kg', 2),
('Harina de maíz', 'Harina para tortillas y empanadas en sacos de 20kg', 1),
('Aceite vegetal', 'Aceite comestible en bidones de 5 litros', 3),
('Azúcar a granel', 'Azúcar blanca en sacos de 50kg', 4),
('Sal refinada', 'Sal para consumo en sacos de 25kg', 5),
('Pasta seca', 'Pasta de trigo en cajas de 10kg', 1),
('Avena a granel', 'Avena en sacos de 25kg', 1),
('Café molido', 'Café en sacos de 10kg', 6),
('Lentejas secas', 'Lentejas empaquetadas en sacos de 20kg', 2);

INSERT INTO Inventario (id_producto, id_proveedor, tipo_movimiento, fecha_movimiento, cantidad)
VALUES 
-- Entradas (compra de productos a proveedores)
(1, 1, 'entrada', '2024-10-01', 100),  
(2, 2, 'entrada', '2024-10-02', 200), 
(3, 3, 'entrada', '2024-10-03', 150),  
(4, 4, 'entrada', '2024-10-04', 300),  
(5, 5, 'entrada', '2024-10-05', 120),  

-- Salidas (productos vendidos o utilizados)
(1, NULL, 'salida', '2024-10-10', 20), 
(2, NULL, 'salida', '2024-10-11', 30), 
(3, NULL, 'salida', '2024-10-12', 40), 
(4, NULL, 'salida', '2024-10-13', 50), 
(5, NULL, 'salida', '2024-10-14', 15); 

INSERT INTO Pedidos (id_cliente, estado_pedido, total)
VALUES 
(1, 'Pendiente', 12.00),
(2, 'Completado', 8.50),
(3, 'Cancelado', 10.00),
(4, 'Preparación', 15.00);

INSERT INTO Detalle_Pedido (id_pedido, id_producto, cantidad, precio)
VALUES 
(1, 1, 2, 5.00), 
(1, 2, 3, 3.00), 
(2, 3, 2, 2.40), 
(2, 4, 4, 2.00), 
(3, 5, 1, 1.50); 

/* PROCEDIMIENTOS ALMACENADOS */

DELIMITER //

CREATE PROCEDURE InsertarControlInventario (
    IN p_id_producto INT,
    IN p_id_proveedor INT,
    IN p_cantidad INT,
    IN p_tipo_movimiento VARCHAR(50)
)
BEGIN
    INSERT INTO Inventario (id_producto, id_proveedor, cantidad, tipo_movimiento)
    VALUES (p_id_producto, p_id_proveedor, p_cantidad, p_tipo_movimiento);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertarProducto (
    IN p_nombre_producto VARCHAR(100),
    IN p_descripcion VARCHAR(255),
    IN p_id_categoria INT
)
BEGIN
    INSERT INTO Producto (nombre_producto, descripcion, id_categoria)
    VALUES (p_nombre_producto, p_descripcion, p_id_categoria);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertarCategoria (
    IN p_nombre_categoria VARCHAR(50)
)
BEGIN
    INSERT INTO Categoria (nombre_categoria)
    VALUES (p_nombre_categoria);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertarProveedor (
    IN p_nombre_proveedor VARCHAR(100),
    IN p_contacto_proveedor VARCHAR(100),
    IN p_telefono_proveedor VARCHAR(20),
    IN p_direccion_proveedor VARCHAR(200)
)
BEGIN
    INSERT INTO Proveedor (nombre_proveedor, contacto_proveedor, telefono_proveedor, direccion_proveedor)
    VALUES (p_nombre_proveedor, p_contacto_proveedor, p_telefono_proveedor, p_direccion_proveedor);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertarCliente(
    IN p_nombre_cliente VARCHAR(100),
    IN p_telefono_cliente VARCHAR(20),
    IN p_correo_cliente VARCHAR(100),
    IN p_puntos_fidelidad INT
)
BEGIN
    INSERT INTO Clientes (nombre_cliente, telefono_cliente, correo_cliente, puntos_fidelidad)
    VALUES (p_nombre_cliente, p_telefono_cliente, p_correo_cliente, p_puntos_fidelidad);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE InsertarPromocion(
    IN p_descripcion_promocion VARCHAR(255),
    IN p_puntos_necesarios INT,
    IN p_descuento DECIMAL(5, 2)
)
BEGIN
    INSERT INTO Promociones (descripcion_promocion, puntos_necesarios, descuento)
    VALUES (p_descripcion_promocion, p_puntos_necesarios, p_descuento);
END //

DELIMITER ;



DELIMITER //

CREATE PROCEDURE InsertarDetallePedido(
    IN p_id_detalle INT,
    IN p_id_pedido INT,
    IN p_id_producto INT,
    IN p_cantidad INT,
    IN p_precio DECIMAL(10, 2)
)
BEGIN
    INSERT INTO detalle_pedido (id_detalle, id_pedido, id_producto, cantidad, precio)
    VALUES (p_id_detalle, p_id_pedido, p_id_producto, p_cantidad, p_precio);
END //

DELIMITER ;