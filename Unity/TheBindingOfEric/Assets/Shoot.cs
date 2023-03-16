using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Shoot : MonoBehaviour
{
    public float speed = 10f;
    public float lifeTime = 2f;

    // Start is called before the first frame update
    void Start()
    {
        Destroy(gameObject, lifeTime); // Destruye la bala después de lifeTime segundos
    }

    // Update is called once per frame
    void Update()
    {
        transform.position += transform.right * speed * Time.deltaTime; // Mueve la bala hacia adelante
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        // Destruye la bala si colisiona con otro objeto
        Destroy(gameObject);
    }
}
