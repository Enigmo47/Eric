// using System.Collections;
// using System.Collections.Generic;
// using UnityEngine;

// public class Movimiento : MonoBehaviour
// {
//     public float velocidadMovimiento = 5f; // Velocidad de movimiento del jugador
//     public float velocidadRotacion = 200f; // Velocidad de rotación del jugador
//     public GameObject balaPrefab; // Prefab de la bala
//     public Transform puntoAparicionBala; // Punto de aparición de la bala
//     public float fireRate = 0.5f; // Cantidad de tiempo entre cada disparo
//     private float nextFire = 0.0f; // Tiempo en el que se puede realizar el próximo disparo
//     private Disparo disparo; // Referencia al componente Disparo en el objeto del jugador

//     void Start()
//     {
//         disparo = GetComponent<Disparo>();
//     }

//     // Actualizar el movimiento y la rotación del jugador
//     private void Update()
//     {
//         // Obtener la entrada del teclado para el movimiento horizontal y vertical
//         float movimientoHorizontal = Input.GetAxisRaw("Horizontal");
//         float movimientoVertical = Input.GetAxisRaw("Vertical");

//         Vector2 direccionMovimiento = new Vector2(movimientoHorizontal, movimientoVertical).normalized;
//         // Calcular la velocidad de movimiento y aplicarla al jugador
//         float velocidadActualMovimiento = direccionMovimiento.magnitude * velocidadMovimiento;

//         // Si hay colisiones, ajustar la velocidad del movimiento
//         RaycastHit2D hit = Physics2D.Raycast(transform.position, direccionMovimiento, velocidadActualMovimiento * Time.deltaTime);
//         if (hit.collider != null)
//         {
//             // Calculamos la distancia entre la posición actual del jugador y el punto de colisión
//             float distancia = hit.distance;

//             // Si la distancia es menor que la velocidad de movimiento, reducimos la velocidad del movimiento
//             if (distancia < velocidadActualMovimiento)
//             {
//                 velocidadActualMovimiento = distancia;
//             }
//         }

//         // Actualizar la posición del jugador
//         transform.Translate(direccionMovimiento * velocidadActualMovimiento * Time.deltaTime);

//         // Detectar disparos
//         if (Input.GetAxis("HorizontalShoot") != 0 || Input.GetAxis("VerticalShoot") != 0)
//         {
//             float angle = Mathf.Atan2(Input.GetAxis("VerticalShoot"), Input.GetAxis("HorizontalShoot")) * Mathf.Rad2Deg;

//             transform.rotation = Quaternion.Euler(new Vector3(0, 0, angle));

//             if (Input.GetKeyDown(KeyCode.Space) && Time.time > nextFire)
//             {
//                 nextFire = Time.time + fireRate;
//                 disparo.Disparar();
//             }
//         }
//     }
//}


 using System.Collections;
 using System.Collections.Generic;
 using UnityEngine;
 public class Movimiento : MonoBehaviour
 {
     public float velocidadMovimiento = 5f; // Velocidad de movimiento del jugador
     public float velocidadRotacion = 200f; // Velocidad de rotación del jugador
     public GameObject balaPrefab; // Prefab de la bala
     public Transform puntoAparicionBala; // Punto de aparición de la bala
     public float fireRate = 0.5f; // Cantidad de tiempo entre cada disparo
     private float nextFire = 0.0f; // Tiempo en el que se puede realizar el próximo disparo
     private Disparo disparo; // Referencia al componente Disparo en el objeto del jugador
     void Start()
     {
         disparo = GetComponent<Disparo>();
     }
     // Actualizar el movimiento y la rotación del jugador
     private void Update()
     {
         // Obtener la entrada del teclado para el movimiento horizontal y vertical
         float movimientoHorizontal = Input.GetAxisRaw("Horizontal");
         float movimientoVertical = Input.GetAxisRaw("Vertical");
         // Calcular la dirección del movimiento
         Vector2 direccionMovimiento = new Vector2(movimientoHorizontal, movimientoVertical).normalized;
         // Calcular la velocidad de movimiento y aplicarla al jugador
         float velocidadActualMovimiento = direccionMovimiento.magnitude * velocidadMovimiento;
//         RaycastHit2D hit = Physics2D.Raycast(transform.position, direccionMovimiento, velocidadActualMovimiento * Time.deltaTime);
//         if (hit.collider != null)
//         {
//             // Calculamos la distancia entre la posición actual del jugador y el punto de colisión
//             float distancia = hit.distance;

//             // Si la distancia es menor que la velocidad de movimiento, reducimos la velocidad del movimiento
//             if (distancia < velocidadActualMovimiento)
//             {
//                 velocidadActualMovimiento = distancia;
//             }
//         }
      
         transform.Translate(direccionMovimiento * velocidadActualMovimiento * Time.deltaTime);
     if (Input.GetAxis("HorizontalShoot") != 0 || Input.GetAxis("VerticalShoot") != 0)
     {
         float angle = Mathf.Atan2(Input.GetAxis("VerticalShoot"), Input.GetAxis("HorizontalShoot")) * Mathf.Rad2Deg;
         transform.rotation = Quaternion.Euler(new Vector3(0, 0, angle));
         if (Input.GetKeyDown(KeyCode.Space) && Time.time > nextFire)
         {
             nextFire = Time.time + fireRate;
             disparo.Disparar();
         }
     }
     }
}
