using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    [SerializeField] private float vida;

    public void TomarDaño(float daño){
        vida -= daño;
        if(vida <= 0){
            Muerte();
        }
    }

    private void Muerte(){
        Instantiate(transform.position, Quaternion.indentity);
        Destroy(GameObject);
    }
}
