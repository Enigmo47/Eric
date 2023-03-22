using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movimiento : MonoBehaviour
{
    public float speed;
    public GameObject disparoPrefab;
    public float fireRate = 1f;
    private float nextFire = 0f;
    
    // Update is called once per frame
    void Update()
    {
        if(Input.GetAxis("Horizontal")!=0 || Input.GetAxis("Vertical")!=0)
        {
            transform.position += new Vector3(speed * Input.GetAxis("Horizontal") * Time.deltaTime, speed * Input.GetAxis("Vertical") * Time.deltaTime, 0);
        }

        if (Input.GetAxis("HorizontalShoot") != 0 || Input.GetAxis("VerticalShoot") != 0)
        {
            float angle = Mathf.Atan2(Input.GetAxis("VerticalShoot"), Input.GetAxis("HorizontalShoot")) * Mathf.Rad2Deg;
            transform.rotation = Quaternion.Euler(new Vector3(0, 0, angle));

            if (Time.time > nextFire)
            {
                nextFire = Time.time + fireRate;
                Shoot();
            }
        }
    }

    private void Shoot()
    {
        GameObject disparo = Instantiate(disparoPrefab, transform.position, transform.rotation);
        Destroy(disparo, 2f);
    }
}
