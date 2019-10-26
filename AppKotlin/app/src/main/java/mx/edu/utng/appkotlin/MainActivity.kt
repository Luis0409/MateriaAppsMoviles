package mx.edu.utng.appkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = arrayOf("ListView","Activities","SharedPreferences","Audio","SQLite")
        val pri = Intent(this, ListView::class.java)
        val seg = Intent(this, Activities::class.java)
        val ter = Intent(this, SharedPreferences::class.java)
        val cuar = Intent(this, audio::class.java)
        val quin = Intent(this, SQLite::class.java)
        var pag = arrayOf(pri,seg,ter,cuar,quin)

        var adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista)
        list1.adapter = adaptador1

        list1.setOnItemClickListener { adapterView, view, i, l ->
            startActivity(pag[i])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg: String = ""
        when(item.itemId){

            R.id.itmList->{
                msg="Selecciono List View"
                startActivity(Intent(this, ListView::class.java))
            }
            R.id.itmShared->{
                msg="Selecciono Shared Preferences"
                startActivity(Intent(this, SharedPreferences::class.java))
            }
            R.id.itmAct->{
                msg="Selecciono Activities"
                startActivity(Intent(this, Activities::class.java))
            }
            R.id.itmSql->{
                msg="Selecciono SQLite"
                startActivity(Intent(this, SQLite::class.java))
            }
            R.id.itmAudio->{
                msg="Selecciono Audio"
                startActivity(Intent(this, audio::class.java))
            }
            R.id.itmSalir->{
                System.exit(0)
            }
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

}
