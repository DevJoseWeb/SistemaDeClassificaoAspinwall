import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { Observable, empty, of, Subject } from 'rxjs';
import { catchError } from 'rxjs/operators';
import * as moment from 'moment';

import { CorService } from '../../paginas/cor/cor.service';
import { ProdutoService } from '../produto.service';
import { MarcaService } from '../../paginas/marca/marca.service';
import { GrupoService } from '../../paginas/grupo/grupo.service';
import { EmbalagemService } from '../../paginas/embalagem/embalagem.service';
import { AlertModalService } from '../../../shared/alert-modal/alert-modal.service';
import { UnidadeService } from '../../paginas/unidade/unidade-service';
import { TipoService } from '../../paginas/tipo/tipo.service';

import { Produto } from '../produto';
import { Marca } from '../../paginas/marca/marca';
import { Grupo } from '../../paginas/grupo/grupo';
import { Embalagem } from '../../paginas/embalagem/embalagem';
import { Cor } from '../../../component/paginas/cor/cor';
import { Tipo } from '../../paginas/tipo/tipo';
import { Unidade } from '../../paginas/unidade/unidade';

@Component({
  selector: 'app-produto-form',
  templateUrl: 'produto-form.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['produto-form.component.scss'],
  preserveWhitespaces: true
})

export class ProdutoFormComponent implements OnInit {
  produtos$: Observable<Produto[]>;
  cors$: Observable<Cor[]>;
  marcas$: Observable<Marca[]>;
  grupos$: Observable<Grupo[]>;
  embalagens$: Observable<Embalagem[]>;
  unidades$: Observable<Unidade[]>;
  tipos$: Observable<Tipo[]>;
  error$ = new Subject<boolean>();
  closeResult: string;
  produtoForm: FormGroup;
  submitted = false;
  @Input() descricao: string;
  @Input() datacadastro: string;
  @Input() fabricacao: string;
  @Input() vencimento: string;
  @Input() status = 'Ativo';
  @Input() altura: number;
  @Input() largura: number;
  @Input() comprimento: number;

  constructor(
    private produtoService: ProdutoService,
    private corService: CorService,
    private marcaService: MarcaService,
    private grupoService: GrupoService,
    private embalagemService: EmbalagemService,
    private unidadeService: UnidadeService,
    private tipoService: TipoService,
    private formBuilder: FormBuilder,
    private modalService: NgbModal,
    private alertService: AlertModalService
    ) { }
ngOnInit() {
    this.onIniciaProduto();
    this.datacadastro = moment().format('DD/MM/YYYY HH:mm:ss');
    this.fabricacao = moment().format('DD/MM/YYYY');
    this.vencimento = moment().format('DD/MM/YYYY');
  }

  ngAfterContentInit(): void {
    this.onForm();
    this.onRefreshCor();
    this.onRefreshMarca();
    this.onRefreshGrupo();
    this.onRefreshEmbalagem();
    this.onRefreshUnidade();
    this.onRefreshTipo();
}

onForm() {
  this.produtoForm = this.formBuilder.group({
    _id: [],
    descricao: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(250)]],
    preco: [],
    durabilidade: [],
    peso: [],
    rotulagem: [],
    status: this.status,
    cor: [], // [null, [Validators.required, Validators.minLength(3), Validators.maxLength(250)]],
    grupo: [],
    marca: [],
    embalagem: [],
    imagem: [],
    altura: [null, [Validators.required]],
    largura: [null, [Validators.required]],
    comprimento: [null, [Validators.required]],
    formato: [],
    datacadastro: this.datacadastro,
    fabricacao: [],
    vencimento: [],
    });
}

  onRefreshProduto() {
    this.produtos$ = this.produtoService.getProdutos();
    if (this.produtos$ != null) {
      console.log('LISTA ATUALIZADA');
    } else {
      this.handleError();
      return empty();
    }
   }

  onIniciaProduto() {
    this.produtos$ = this.produtoService.getProdutos()
      .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
        })
    );
  }

  onRefreshCor() {
    this.cors$ = this.corService.getCores()
      .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
        })
    );
  }

  onRefreshMarca() {
    this.marcas$ = this.marcaService.getMarca()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
        })
    );
  }

  onRefreshGrupo() {
    this.grupos$ = this.grupoService.getGrupo()
    .pipe(
      catchError(error => {
        console.error(error);
         this.handleError();
        return empty();
        })
    );
  }

  onRefreshEmbalagem() {
    this.embalagens$ = this.embalagemService.getEmbalagem()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
        })
    );
  }

  onRefreshUnidade() {
    this.unidades$ = this.unidadeService.getUnidade()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );
  }

  onRefreshTipo() {
    this.tipos$ = this.tipoService.getTipo()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );
  }
 
   /* Abri o painel para cadastro de Produtos */
  openCadastrar(content: any) {
    this.modalService.open(content, {
       windowClass: 'dark-modal',
       size: 'lg',
       centered: true,
       backdropClass: 'light-blue-backdrop'
       });
   }

    /* Abri o painel para editar os Produtos */
   openEditar() {

    const soma = this.produtoForm.valueChanges
    .subscribe(value => console.log(value));
/* 
    this.modalService.open(content, {
       windowClass: 'dark-modal',
       size: 'lg',
       centered: true,
       backdropClass: 'light-blue-backdrop'
       }); */
   }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  hasError(field: string) {
    return this.produtoForm.get(field).errors;
  }

  onSubmit() {
    this.submitted = true;
    console.log(this.produtoForm.value);
    if (this.produtoForm.valid) {
        this.produtoService.createProduto(this.produtoForm.value).subscribe(
        success => {
          console.log('SALVO COM SUCESSO');
          this.onRefreshProduto();
          this.produtoForm.reset();
          this.CadastroSucesso();
        },
         error =>
         this.handleError(),
        () =>
        console.log('request completo')
      );
    }
  }

/* chamadada Async */
/*   private searchPrdoutos(descricao: string) {
    this.produtoService.searchPrdoutos(descricao)
      .subscribe(
        dados => this.produtos$ = dados
        );
        console.log('PRODUTOX: ' + this.produtos$);
  } */

  searchProdutos(descricao: string) {
     this.produtos$ =  this.produtoService.searchProdutosDescricao(descricao);
       if (this.descricao != null ) {
        console.log('SUCESSO: ' + this.produtos$);
       } else {
        console.log('ERRO: ' + this.produtos$);
        this.handleError();
       }
  }

  uPpercase(event: any) {
    event.target.value = event.target.value.toUpperCase();
  }

  onReset() {
    this.submitted = false;
    this.produtoForm.reset();
    this.handleSucesso();
   }

  onSubmitShearch() {
    this.searchProdutos(this.descricao);
    this.handleSucesso();
   }

  handleSucesso() {
    this.alertService.showAlertSuccess('Aguarde CONECTANDO ao servidor......OK');
   }

  CadastroSucesso() {
    this.alertService.showAlertSuccess('Aguarde Salvando.......OK');
   }

  ListaSucesso() {
    this.alertService.showAlertSuccess('Atualizando a Lista....');
   }

  handleError() {
    this.alertService.showAlertDanger('Servidor ( RETONOU NEGATIVO ) ....Erro');
   }
}
