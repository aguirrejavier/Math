package matrizMath;

import java.util.Arrays;

import excepciones.DistDimException;
import excepciones.InvalidDimException;
import vectorMath.VectorMath;

public class MatrizMath {
		
		private final int filas;
		private final int columnas;
		private final int dim;
		private Double mat[][];
		
		//CONSTRUCTOR
		
		public MatrizMath(int filas, int columnas) {
			if(filas<1 || columnas<1)
				throw new InvalidDimException("Las filas y columnas deben ser mayores a 0");
			this.filas=filas;
			this.columnas=columnas;
			this.dim=filas*columnas;
			this.mat=new Double[filas][columnas];
		}
		
		
		//GETTERS Y SETTERS
		
		public Double[][] getMat() {
			return mat;
		}


		public void setMat(Double[][] mat) {
			this.mat = mat;
		}


		public int getFilas() {
			return filas;
		}


		public int getColumnas() {
			return columnas;
		}


		public int getDim() {
			return dim;
		}


		

		//toString Equals HashCode
		
		@Override
		public String toString() {
			return "MatrizMath [filas=" + filas + ", columnas=" + columnas + ", dim=" + dim + ", mat="
					+ Arrays.toString(mat) + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + columnas;
			result = prime * result + dim;
			result = prime * result + filas;
			result = prime * result + Arrays.deepHashCode(mat);
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MatrizMath other = (MatrizMath) obj;
			if (columnas != other.columnas)
				return false;
			if (dim != other.dim)
				return false;
			if (filas != other.filas)
				return false;
			if (!Arrays.deepEquals(mat, other.mat))
				return false;
			return true;
		}
		
		//OPERACIONES CON MATRICES


		public MatrizMath sumar(MatrizMath mat) {
			if(filas!=mat.filas || columnas!=mat.columnas)
				throw new DistDimException("Las matrices deben tener la misma dimension");
			MatrizMath suma = new MatrizMath(filas, columnas);
			for(int i=0; i<filas; i++)
				for(int j=0; j<columnas; j++)
					suma.mat[i][j]=this.mat[i][j]+mat.mat[i][j];
			return suma;
		}
		
		public MatrizMath restar(MatrizMath mat) {
			if(filas!=mat.filas || columnas!=mat.columnas)
				throw new DistDimException("Las matrices deben tener la misma dimension");
			MatrizMath resta = new MatrizMath(filas, columnas);
			for(int i=0; i<filas; i++)
				for(int j=0; j<columnas; j++)
					resta.mat[i][j]=this.mat[i][j]-mat.mat[i][j];
			return resta;
		}
		
		public MatrizMath multiplicar(MatrizMath mat) {
			if(columnas!=mat.filas)
				throw new DistDimException("Las dimensiones deben ser AxN y NxB");
			
			MatrizMath producto = new MatrizMath(this.filas,mat.columnas);
			
			for(int i=0; i<producto.filas; i++) {
				for(int j=0; j<producto.columnas; j++) {
					producto.mat[i][j]=0.0;
					for(int k=0; k<columnas; k++) {
						producto.mat[i][j] += this.mat[i][k] * mat.mat[k][j];
					}
				}
			}
			return producto;
		}
		
		public MatrizMath multiplicar(VectorMath vec) {
			if(columnas!=vec.getDim())
				throw new DistDimException("Se debe cumplir DimMatriz: AxB DimVector: B");
			MatrizMath producto = new MatrizMath(vec.getDim(),1);
			for(int i=0; i<filas; i++) {
				producto.mat[i][0]=0.0;
				for(int j=0; j<columnas; j++) {
					producto.mat[i][0] += this.mat[i][j] * vec.getCoord()[j];
				}
			}
			return producto;
		}
		
		
		
}
