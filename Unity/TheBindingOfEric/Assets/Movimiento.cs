using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movimiento : MonoBehaviour
{
    public float speed;
    public GameObject bulletPrefab;
    private float lastShotTime;

    // Start is called before the first frame update
    void Start()
    {
        lastShotTime = Time.time;
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetAxis("Horizontal")!=0 || Input.GetAxis("Vertical")!=0){
            transform.position += new Vector3(speed * Input.GetAxis("Horizontal") * Time.deltaTime, speed * Input.GetAxis("Vertical") * Time.deltaTime);
        }
        if(Input.GetAxis("HorizontalShoot")!=0 || Input.GetAxis("VerticalShoot")!=0){
            float x = Input.GetAxis("HorizontalShoot");
            float y = Input.GetAxis("VerticalShoot");
            if (x != 0 || y != 0)
            {
                float angle = Mathf.Atan2(y, x) * Mathf.Rad2Deg;
                transform.rotation = Quaternion.Euler(new Vector3(0, 0, angle));
                Shoot();
            }
        }
    }

    void Shoot()
    {
        if(Time.time - lastShotTime >= 1f)
        {
            GameObject bullet = Instantiate(bulletPrefab, transform.position, transform.rotation);
            lastShotTime = Time.time;
        }
    }
}
