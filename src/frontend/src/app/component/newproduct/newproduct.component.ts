import {Component, OnInit} from '@angular/core';
import {DataState} from "../../enum/datastate.enum";
import {BehaviorSubject, catchError, map, Observable, of, startWith} from "rxjs";
import {State} from "../../interface/state";
import {CustomHttpResponse, Page} from "../../interface/appstates";
import {Product} from "../../interface/product";
import {User} from "../../interface/user";
import {Stats} from "../../interface/stats";
import {ProductService} from "../../service/product.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-newproduct',
  templateUrl: './newproduct.component.html',
  styleUrls: ['./newproduct.component.css']
})
export class NewproductComponent implements OnInit{
  newProductState$: Observable<State<CustomHttpResponse<Page<Product> & User & Stats>>>;
  private dataSubject = new BehaviorSubject<CustomHttpResponse<Page<Product> & User & Stats>>(null);
  private isLoadingSubject = new BehaviorSubject<boolean>(false);
  isLoading$ = this.isLoadingSubject.asObservable();
  readonly DataState = DataState;

  constructor(private productService: ProductService) { }
  ngOnInit(): void {
    this.newProductState$ = this.productService.products$()
      .pipe(
        map(response => {
          console.log(response);
          this.dataSubject.next(response);
          return {dataState: DataState.LOADED, appData: response};
        }),
        startWith({dataState: DataState.LOADING}),
        catchError((error: string) => {
          return of({dataState: DataState.ERROR, error})
        })
      )
  }

  createProduct(newProductForm: NgForm): void {
    this.isLoadingSubject.next(true);
    this.newProductState$ = this.productService.newProducts$(newProductForm.value)
      .pipe(
        map(response => {
          console.log(response);
          newProductForm.reset({type: 'INDIVIDUAL', status: 'ACTIVE'});
          this.isLoadingSubject.next(false);
          return {dataState: DataState.LOADED, appData: this.dataSubject.value};
        }),
        startWith({dataState: DataState.LOADED, appData: this.dataSubject.value}),
        catchError((error: string) => {
          this.isLoadingSubject.next(false);
          return of({dataState: DataState.LOADED, error})
        })
      )
  }
}
