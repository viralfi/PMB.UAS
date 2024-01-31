import { Component } from '@angular/core';
import {DataState} from "../../enum/datastate.enum";
import {BehaviorSubject, catchError, map, Observable, of, startWith, switchMap} from "rxjs";
import {State} from "../../interface/state";
import {ProductState, CustomHttpResponse} from "../../interface/appstates";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  productState$: Observable<State<CustomHttpResponse<ProductState>>>;
  readonly DataState = DataState;
  private dataSubject = new BehaviorSubject<CustomHttpResponse<ProductState>>(null);
  private isLoadingSubject = new BehaviorSubject<boolean>(false);
  isLoading$ = this.isLoadingSubject.asObservable();
  private readonly CUSTOMER_ID: string = 'id';

  constructor(private activatedRoute: ActivatedRoute, private productService: ProductService) {
  }

  ngOnInit(): void {
    this.productState$ = this.activatedRoute.paramMap.pipe(
      switchMap((params: ParamMap) => {
        return this.productService.product$(+params.get(this.CUSTOMER_ID))
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
      })
    );
  }

  // updateProduct(productForm: NgForm): void {
  //   this.isLoadingSubject.next(true);
  //   this.productState$ = this.productService.update$(productForm.value)
  //     .pipe(
  //       map(response => {
  //         console.log(response);
  //         this.dataSubject.next({
  //           ...response,
  //           data: {
  //             ...response.data,
  //             product: {
  //               ...response.data.product,
  //               invoices: this.dataSubject.value.data.product.invoices
  //             }
  //           }
  //         });
  //
  //         this.isLoadingSubject.next(false);
  //         return {dataState: DataState.LOADED, appData: this.dataSubject.value};
  //       }),
  //       startWith({dataState: DataState.LOADED, appData: this.dataSubject.value}),
  //       catchError((error: string) => {
  //         this.isLoadingSubject.next(false);
  //         return of({dataState: DataState.ERROR, error})
  //       })
  //     )
  // }
}
