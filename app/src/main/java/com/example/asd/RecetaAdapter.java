package com.example.asd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder> {

    private List<Receta> listaRecetas;
    private Context context;

    public RecetaAdapter(List<Receta> listaRecetas, Context context) {
        this.listaRecetas = listaRecetas;
        this.context = context;
    }

    @Override
    public RecetaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        return new RecetaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecetaViewHolder holder, int position) {
        Receta receta = listaRecetas.get(position);
        holder.nombreTextView.setText(receta.getNombre());
        holder.ingredientesView.setText(receta.getIngredientes());
        holder.instruccionesView.setText(receta.getInstrucciones());

        String imagenURL = receta.getImagenURL();

        Log.d("RecetaAdapter", "URL de imagen: " + imagenURL);
        if (imagenURL != null && !imagenURL.isEmpty()) {
            Picasso.get()
                    .load(imagenURL)
                    .placeholder(R.drawable.encabezado)
                    .error(R.drawable.margarita)
                    .fit()
                    .into(holder.imagenImageView);
        } else {
            holder.imagenImageView.setImageResource(R.drawable.encabezado);
        }
    }

    @Override
    public int getItemCount() {
        return listaRecetas.size();
    }

    public class RecetaViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagenImageView;
        public TextView nombreTextView, ingredientesView, instruccionesView;

        public RecetaViewHolder(View view) {
            super(view);
            imagenImageView = view.findViewById(R.id.itemsImagenReceta);
            nombreTextView = view.findViewById(R.id.itemTextImagen);
            ingredientesView = view.findViewById(R.id.itemIngredientesReceta);
            instruccionesView = view.findViewById(R.id.itemInstruccionesReceta);

        }
    }
    public void setRecetas(List<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }
}
